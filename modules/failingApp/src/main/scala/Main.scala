import scalaxb._
import com.test.generated._

object Main extends App with com.test.generated.XMLProtocol {
    val myXml =
<FailureResponse xmlns="http://tempuri.org/" Stuff="1">
    <FailureResponse>
        <Failures>
            <TypeResponses>
                <Reasons>
                    <Types>
                        <Codes Code="123">
                        </Codes>
                    </Types>
                </Reasons>
            </TypeResponses>
        </Failures>
    </FailureResponse>
</FailureResponse>

    println(myXml)
    println(fromXML[FailureResponse](myXml, List())) // This fails
}
