package Steps;

import org.junit.jupiter.api.Assertions;

import User.User;
import Utils.ApiUtils;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

public class Steps_api {

	  private Response resposta;

	    @Dado("que envio uma requisição POST para {string} com os detalhes do usuário")
	    public void que_envio_uma_requisicao_post_para_com_os_detalhes_do_usuario(String endpoint) {
	        try {
	            User usuario = new User("Neiva", "Qa chefe");
	            String corpo = ApiUtils.convertObjectToJson(usuario);
	            resposta = ApiUtils.sendPostRequest("https://reqres.in" + endpoint, corpo);
	        } catch (Exception e) {
	            e.printStackTrace();
	            Assertions.fail("Falha ao converter objeto para JSON: " + e.getMessage());
	        }
	    }

	    @Entao("o status da resposta deve ser {int}")
	    public void o_status_da_resposta_deve_ser(Integer codigoStatus) {
	        Assertions.assertEquals(codigoStatus.intValue(), resposta.getStatusCode());
	    }

	    @Entao("o corpo da resposta deve conter {string} com valor {string}")
	    public void o_corpo_da_resposta_deve_conter_com_valor(String chave, String valor) {
	        Assertions.assertEquals(valor, resposta.jsonPath().getString(chave));
	    }
	}
