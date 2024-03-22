package br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.lambda.json.ResponseJson;
import br.com.pupposoft.fiap.sgp.registroponto.consumer.usecase.RegistrarPontoUsecase;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

@ExtendWith({MockitoExtension.class, SystemStubsExtension.class})
class EntrypointUnitTest {
	@InjectMocks
	private Entrypoint entrypoint;

	@Mock
	private RegistrarPontoUsecase registrarPontoUsecase;
	
	@SystemStub
	private static EnvironmentVariables environmentVariables;

	@BeforeAll
	private static void config() {
		environmentVariables.set("IS_UNIT_TEST", "true");
	}
	
	@Test
	void shouldSucessOnHandleRequest() {
		final String input = "{Records=[{messageId=7341b3b1-0c15-460b-bb7d-33e9ae3d9d58, receiptHandle=AQEBjmbF/p5Ihri0T7YKfgAq5kYogpz9Czo6G9xQk851pngFxheZli1pKEiudBeAWs7R7Cf/A3lQwhYSyJUaC43aoRNG/mBAQ6GcO4AzmEPFIvQc/cr4C7PSYlqFsu3C7D6FNlwCMgnHGGvAd7KqaQAzSV9zitMCbJUirfJq/AYfGfv4rLHdPev3sySik+8M4col3Kz+yIgYI7ChMDcM2XGlFOItqDg3pTnwP3R2O2IPjXje9wgMIlvJq2w5bsmzhzICAXlOuBqZw/Sns7ipULplfs3nla4TF7kTZ4znhYUdEGAfOT/pmZurb8QhcSCqOfgpc1MVwEGw/eQnJaU0mRd8hhIa8amJ2Dr+yvo6xOh6YlF6ly8YsS3INqTFpNGQ0lXcQGbFeZ2DlFJt7YB20MUGHqTW3m7vCHl277s0SZDIbZs=, body={\"userId\":15,\"dataHora\":\"2024-03-21T20:29:35.896093573\"}, attributes={ApproximateReceiveCount=5, SentTimestamp=1711063779565, SenderId=AROA6ODU67LH5XW3CR4RT:user2937623=renan.puppo@gmail.com, ApproximateFirstReceiveTimestamp=1711063790786}, messageAttributes={JMS_SQSMessageType={stringValue=text, stringListValues=[], binaryListValues=[], dataType=String}}, md5OfMessageAttributes=3226c32921e2bcda84eed17654164acc, md5OfBody=5613ddbd73d19fc491fc2c51c6901c68, eventSource=aws:sqs, eventSourceARN=arn:aws:sqs:us-west-2:992382745295:sgp-registro-ponto-qeue, awsRegion=us-west-2}]}";
		
		ResponseJson handleRequest = entrypoint.handleRequest(input, null);
		
		assertNotNull(handleRequest);
		assertEquals(200, handleRequest.getStatusCode());
		
		
		
		//Continuar asserts e verifys
	}
}
