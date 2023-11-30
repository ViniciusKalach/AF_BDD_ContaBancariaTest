import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	private int accountBalance;
    private boolean isSpecial;
    private int transferCount;

	@Given("Um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
		isSpecial = true;
        accountBalance = int1;
	}

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) {
		saque(int1);
	}

	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) {
		assert int1 == accountBalance;
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
		assert isSpecial;
	}

	@Given("Um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
		accountBalance = int1;
        isSpecial = false;
	}

	@When("solicitar um saque no valor de {int} reais")
	public void solicitar_um_saque_no_valor_de_reais(Integer int1) {
		saque(int1);
	}

	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		assert transferCount == 0;
	}
	
	public void saque(int amount) {
        if(accountBalance >= amount || isSpecial) {
            accountBalance -= amount;
            transferCount++;
        } else {
            System.out.println("Saldo Insuficiente");
        }
    }
	
	public int getAccountBalance() {
        return accountBalance;
    }
	
	public boolean isSpecial() {
        return isSpecial;
    }
	
	public void setSpecial(boolean special) {
        isSpecial = special;
    }
}
