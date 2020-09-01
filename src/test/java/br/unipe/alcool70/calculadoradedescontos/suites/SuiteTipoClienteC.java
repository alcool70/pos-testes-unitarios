package br.unipe.alcool70.calculadoradedescontos.suites;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
        "br.unipe.alcool70.calculadoradedescontos",
        "br.unipe.alcool70.calculadoradedescontos.model"
})

@IncludeTags("ClienteC")
public class SuiteTipoClienteC {}
