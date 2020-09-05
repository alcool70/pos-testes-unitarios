package br.unipe.alcool70.calculadoradedescontos.ui.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		 plugin = {"pretty", "html:target/html-report", "json:target/cucumber.json"},
		 glue = {
					"br.unipe.alcool70.calculadoradedescontos.ui.steps",
					"br.unipe.alcool70.calculadoradedescontos.ui.specs"
		 },
		 features = "src/test/resources/features",
		 strict = true,
		 tags = "@all" //Criar tag @cliente_C(Victor)
)
public class CucumberTests {}
