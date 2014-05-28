<%@page import="it.carlom.amandolaelezioni.Sezione"%>
<%@page import="it.carlom.amandolaelezioni.Elezioni"%>
<html>
<body>

	<%
	java.util.ArrayList<Sezione> sezioni = Elezioni.getElezioni().sezioni;
	
	int lista1 = 0;
	int lista2 = 0;
	int lista3 = 0;
	
	for(Sezione sez : sezioni){
		
		lista1 += sez.getLista1();
		lista2 += sez.getLista2();
		lista3 += sez.getLista3();
		
	}
	
	%>
	
	<a>Lista 1: <%= lista1 %></a>
	<a>Lista 2: <%= lista2 %></a>
	<a>Lista 3: <%= lista3 %></a>

</body>
</html>
