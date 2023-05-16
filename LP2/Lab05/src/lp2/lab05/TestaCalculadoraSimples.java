package lp2.lab05;

import org.junit.*;

public class TestaCalculadoraSimples {
	@Test public void testaCalculadoraSimples() {
		CalculadoraSimples calc = new CalculadoraSimples();
		Assert.assertEquals(0, calc.memoryRecovery());
		Assert.assertEquals(4, calc.soma(2, 2));
		Assert.assertEquals(0, calc.subtracao(2, 2));
		Assert.assertEquals(81, calc.multiplicacao(9, 9));
		Assert.assertEquals(1, calc.divisao(9, 9));
		Assert.assertEquals(-1, calc.divisao(9, 0));
		calc.memorySave(9);
		Assert.assertEquals(9, calc.memoryRecovery());
		calc.memoryClean();
		Assert.assertEquals(0, calc.memoryRecovery());
		calc.memorySave(10);
		calc.memoryMais(5);
		Assert.assertEquals(15, calc.memoryRecovery());
	}
}
