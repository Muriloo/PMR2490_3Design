<%-- 
    Document   : editarprojeto
    Created on : 20/11/2014, 15:14:57
    Author     : PFA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
<head>
<link rel="stylesheet" type="text/css" href="index.css" media="all">
</head>
    
<body>
    
<div style="height:90px;margin:0px;background-color: #6ED4B8">
<div id="header" style="vertical-align: top;height:80px">
    <a href="index.html">
        <img src="../images/Logo2.bmp" alt="3Design" style="width:250px;height:80px;float: left">
    </a>
    <div style="float:right;">
    <a class="header" href="../index.html">Sign Up </a>
    <span style="letter-spacing:14px;"> |</span>
    <a class="header" href="../index.html">Log In </a>
    <span style="letter-spacing:14px;"> |</span>
    <a href="../index.html">
        <img src="../images/Carrinho.bmp" alt="3Design" style="width:40px;height:40px;position:relative;top:12px">
    </a>
    </div>
    <div style="display:inline;text-align: center">
    <br>
    <form>
        <input type="search" name="firstname" placeholder="Search" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;" size="50">
        <input type="submit" value="" style="background:url(../images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: 6px" />
    </form>
    </div>
</div>
</div>
    
    
    <div class="form_description">
			<h2>Edição de projeto</h2>
			<p>Edite aqui as informações básicas do seu projeto!.</p>
		</div>						
			<ul >
			
					<li id="li_1" >
		<label class="description" for="element_1">Nome do projeto </label>
		<div>
			<input id="element_1" name="element_1" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
                                        </li>	<br>	<li id="li_2" >
		<label class="description" for="element_2">Versão </label>
		<div>
			<input id="element_2" name="element_2" class="element text small" type="text" maxlength="255" value=""/> 
		</div> 
		</li>	<br>	<li id="li_1" >
		<label class="description" for="element_1">Descrição do produto </label>
		<div>
			<textarea id="element_1" name="element_1" class="element textarea large"></textarea> 
		</div> 
		</li> <br>
		<li id="li_4" >
		<label class="description" for="element_4">Preço </label>
		<div>
			<input id="element_4" name="element_4" class="element text small" type="text" maxlength="255" value=""/> 
		</div> 
		</li>
			<br>
					<li class="buttons">
			    <input type="hidden" name="form_id" value="933363" />
			    
				<input id="saveForm" class="button_text" type="submit" name="submit" value="Enviar" />
		</li>
			</ul>
		</form>	
	</div>

    
    
    <div style="height:160px;margin: 0px auto;display: block;background-color:#6ED4B8;clear:both;">
<div id="footer">
    <table id="bottomlinks">
        <tbody>
            <tr>
                <td style="vertical-align: top;width:800px">
                    <h3>Modo de Pagamento</h3>
                    <a href="https://pagseguro.uol.com.br/" target="_blank">
                        <img src="../images/pagseguro.bmp" alt="pagseguro" style="width:100px;height:30px">
                    </a>
                </td>
                <td style="vertical-align: top">
                    <h3>Contato</h3>
                    <h5>Email: contato@3design.com</h5>
                    <h5>Telefone: +55 11 99975-6644</h5>
                    
                </td>
            </tr>
        </tbody>
    </table>
</div>
</div>    
    
</body>
</html>
