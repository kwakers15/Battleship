package oogasalad.com.stripe;

import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import spark.Spark;

/**
 * Class for creating a server and processing payments via the Stripe API. The base for the code has
 * been publicly provided by Stripe, and several parts of the code have been repurposed for usage in
 * this project
 *
 * @author Stripe Inc with contributions from Matthew Giglio and Matthew Knox
 */

public class StripeIntegration {

  private static final String PAID = "paid";
  private static final String API_KEY = "sk_test_51KpiXJCOTY4jZDr4HsPOnix8e9JuuToD27JhxIPCUSlXfPogI"
      + "W3n05G0BxcWAKAipD2DqdBdS6qYhV0XkvfOKhcW00m197JWbn";
  private static final String MY_DOMAIN = "http://localhost:4242";
  private static final String SUCCESS = "/success.html";
  private static final String CANCEL = "/cancel.html";
  private static final String CHECKOUT = "/checkout.html";
  private static final String CHECKOUT_SESSION = "/create-checkout-session";
  private static final String PUBLIC = "public";
  private static final int PORT = 4242;
  private static final int WAIT = 500;
  private static final int CODE = 303;
  private final ResourceBundle resources = ResourceBundle.getBundle("/stripeItemIds");
  private Session session;

  /**
   * Constructor for Stripe integration creates a server upon initialization
   */
  public StripeIntegration() {
    port(PORT);
  }

  /**
   * @param item item to be purchased via internet payments
   * @throws URISyntaxException   thrown if invalid URL
   * @throws IOException          thrown if failure with server port and URL
   * @throws InterruptedException thrown if issue with thread sleeping occurs
   */
  public void purchaseItem(String item)
      throws URISyntaxException, IOException, InterruptedException {
    makeRequest(item);
    openWebPage();
  }

  private String getAPIKeyFromItem(String item) {
    String key = String.join("", item.split(" "));
    return resources.getString(key);
  }

  private void makeRequest(String item) throws InterruptedException {
    Stripe.apiKey = API_KEY;
    Spark.stop();
    Thread.sleep(WAIT);
    port(PORT);
    staticFiles.externalLocation(
        Paths.get(PUBLIC).toAbsolutePath().toString());
    post(CHECKOUT_SESSION, (request, response) -> {
      SessionCreateParams params =
          SessionCreateParams.builder()
              .setMode(SessionCreateParams.Mode.PAYMENT)
              .setSuccessUrl(MY_DOMAIN + SUCCESS)
              .setCancelUrl(MY_DOMAIN + CANCEL)
              .addLineItem(
                  SessionCreateParams.LineItem.builder()
                      .setQuantity(1L)
                      .setPrice(getAPIKeyFromItem(item))
                      .build())
              .build();
      session = Session.create(params);
      response.redirect(session.getUrl(), CODE);
      return "";
    });
  }

  /**
   * Confirmation method for shop buttons to confirm that
   *
   * @return whether the last item was officially purchased
   * @throws StripeException thrown if issue with Stripe's logged payment information
   */
  public boolean hasBeenPaid() throws StripeException {
    if (session == null) {
      return false;
    }
    Session updatedSession = Session.retrieve(session.getId());
    return updatedSession.getPaymentStatus().equals(PAID);

  }

  private void openWebPage() throws URISyntaxException, IOException {
    Desktop.getDesktop().browse(new URI(MY_DOMAIN + CHECKOUT));
  }

}
