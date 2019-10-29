import com.test.generated.{MyRequest, ServiceRequestable, XMLProtocol}
import org.scalatest.{FlatSpec, Matchers}
import scalaxb.`package`.toXML

class Test extends FlatSpec with Matchers {
  import Test._
  "Travolutionary XML Protocol" should "decode a basic XML correctly" in {
    val request: ServiceRequestable =
      MyRequest(
        IP = Some("127.0.0.1"),
        ID = 123,
      )

    val xml = toXML(
      request,
      "request",
      defaultScope
    )(Comtestgenerated_ServiceRequestableFormat)

    xml.toString.contains("xsi:type=\"MyRequest\"") shouldBe true
  }
}

object Test extends XMLProtocol