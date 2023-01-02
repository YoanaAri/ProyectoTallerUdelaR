<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="service.*"%>
<%@page import="java.util.*"%>
    <!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="media/resources/styles.css">
        <script src="media/resources/radioButton.js"></script>
    </head>
    <body class="bg-gray-200">
	    
		<jsp:include page="/WEB-INF/jsp/nav.jsp"/>
		<div class="d-flex ">
		
			<div class="d-flex mt-5 flex-row menu">
	            <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
	         </div>
		
			<!-- <div class="w-full d-flex flex-row align-items-start justify-content-center"> -->
			<div style="width: 60%;" class="d-flex flex-column mt-5 p-4 align-content-center justify-self-center align-self-center">
                <!-- <form class="d-flex flex-column shadow2 p-5 align-self-center align-items-start"> -->
                    <h1 class="titulos mb-8 align-self-center ">INSCRIPCION SALIDA TURISTICA</h1>
                    
                    
                    	<% if(request.getParameter("user") == null){
                    			if(request.getParameter("comboActi") ==null){
                    	%>
                    				<form method="get"> 
                   						 <div class="d-flex flex-row w-full justify-content-around">
                    						<label for="turista" class="form-label justify-self-start">Buscar por departamento:
            									<input type="radio"  id="departamento" name="user" value="departamento" required onchange="activarDeptCat()">
            								</label>
            								<label for="proveedor" class="form-label justify-self-end">Buscar por categoria:
            									<input type="radio"  id="categoria" name="user" value="categoria" required onchange="activarDeptCat()">
            								</label>
            							</div>
            							<div class="d-flex flex-row align-self-center"> 
            								<div id="comboBoxDep" hidden="true"> 
<!-- 	            			<form method="get">              	                    							                    
 -->											<select name="comboDepto" class="form-select btn comboBox is ml-2" aria-label="Default select example">
	  												<option selected>Departamento</option>
								<% 
								
								Set<String> departamentos = (Set<String>) session.getAttribute("departamentos");
								//List<String> departamentos = ((ListaString) session.getAttribute("departamentosMap")).getLista();
					        	if(departamentos != null){
									for(String departamento: departamentos){  
								%>
													<option value="<%=departamento %>"><%=departamento %></option>
									<%
									}
					        	}
									%>	
												</select>
							<!-- 	<input type="submit" value="siguiente"/>
							</form> -->
											</div>						
											<div id="comboBoxCat" hidden="true">
<!-- 							<form method="get">               	                    							                    
 -->											<select name="comboCat" class="form-select btn comboBox is ml-2" aria-label="Default select example">
	  												<option selected>Categoria</option>
	  								<%
	  								Set<String> categorias = (Set<String>) session.getAttribute("categorias");
	  								//List<String> categorias = ((ListaString) session.getAttribute("categorias")).getLista();
						        	if(categorias != null){
										for(String categoria: categorias){ 
	  							
	  								%>
													<option value="<%= categoria%>"><%= categoria %></option>
									<%
										}
						        	}
									%>
												</select>
								<!-- <input type="submit" value="siguiente"/>
							</form> -->
											</div>						
										</div>
										<input type="submit" value="siguiente">
                    				</form> 
                    	<%
                    	///////user es null pero tiene actividad asi que quiere ver el combo saida
                    	
                    			}
                    		if(request.getParameter("comboActi") !=null ){
                    			String activ = request.getParameter("comboActi");
                    			HashMap<String, List<DtSalida>> actividadesMap = (HashMap<String, List<DtSalida>> ) request.getAttribute("actividadesMap");
				        		List<String> salidasCombo = new ArrayList<String>();	
                    	
                    	
                    	%>
			               			<form method="POST" >
			               			
                    					<div class="d-flex flex-row align-items-center">
			                    			<p class="mt-4 mb-2 subtitulos">Seleccione la Salida:</p>	                    						
			               					<div>
												<select name="comboSali" class="form-select btn comboBox is ml-2" aria-label="Default select example">
		  											<option selected>Salidas</option>
                    	<%  		
				        		for(Map.Entry<String, List<DtSalida>> mapaActividad: actividadesMap.entrySet()){
				        			if(activ.equals(mapaActividad.getKey())){
				        				for(DtSalida sali : mapaActividad.getValue()){
				        					salidasCombo.add(sali.getNombre());
				        				}					  				   
				        			}
				        		}
						      	if(!salidasCombo.isEmpty()){
				        			for(String salida: salidasCombo){
				        		%>
				        							<option value="<%=salida%>"><%=salida%></option>
				        			
				        			<%
				        			}				        			
				        		}
				        		%>				        		
												</select>
											</div>
										</div>
										<div class="d-flex flex-row align-items-center">
                    						<p class="mt-4 mb-2 subtitulos">Indique la cantidad de personas:</p>
                    						<input class=" border py-2  pl-9 pr-3 ml-2 form-control w-76" type="number" name="cantidad" min="1"/>
                  	 					</div>
                  	 					<input type="submit" value="done">
                   						<!--  <input type="submit" class="botones mt-4 align-self-center" value="Realizar inscripcion"> -->
									
									</form>
									
				        	 
				        	
				        	
				        	
				        	
				        	
                    	
				        	<%
				        	}} else if (request.getParameter("user").equals("departamento")){
				        		String depto = request.getParameter("comboDepto");
				        		HashMap<String, List<DataActividad>> departamentosMap = (HashMap<String, List<DataActividad>> ) request.getAttribute("departamentosMap");
				        		List<DataActividad> actividadesCombo = new ArrayList<DataActividad>();
				        	%>	
				               <div class="d-flex flex-row align-items-center">
				                    <p class="mt-4 mb-2 subtitulos">Seleccione la actividad:</p>	                    						
				               		<div>
				               			<form method="get">
											<select name="comboActi" class="form-select btn comboBox is ml-2" aria-label="Default select example">
			  								<option selected>Actividades</option>
						      <%  		
				        		for(Map.Entry<String, List<DataActividad>> mapaDepartamento: departamentosMap.entrySet()){
				        			if(depto.equals(mapaDepartamento.getKey())){
				        				actividadesCombo.addAll(mapaDepartamento.getValue());
				        				/* for(DataActividad acti : mapaDepartamento.getValue()){
				        					actividadesCombo.add(acti.getName());
				        				}	 */			   
				        			}
				        		}
						      	if(!actividadesCombo.isEmpty()){
				        			for(DataActividad actividad: actividadesCombo){
				        		%>
										<option value="<%=actividad.getName()%>"><%=actividad.getName()%></option>
				        		
				        			<%
				        			}				        			
				        		}
				        		%>				        		
											</select>
											<input type="submit" value="siguiente">
										</form>
									</div>
								</div>
								
				        	<%
				        	} 
				        	else if (request.getParameter("user").equals("categoria")){
				        		String categ = request.getParameter("comboCat");
				        		HashMap<String, List<DataActividad>> categoriasMap = (HashMap<String, List<DataActividad>> ) request.getAttribute("categoriasMap");
				        		List<String> actividadesCombo = new ArrayList<String>();
						%>
						
								<div class="d-flex flex-row align-items-center">
					                    <p class="mt-4 mb-2 subtitulos">Seleccione la actividad:</p>	                    						
					               		<div>
					               			<form method="get">
												<select name="comboActi" class="form-select btn comboBox is ml-2" aria-label="Default select example">
				  								<option selected>Actividades</option>
						 <%  		
					        		for(Map.Entry<String, List<DataActividad>> mapaCategoria: categoriasMap.entrySet()){
					        			if(categ.equals(mapaCategoria.getKey())){					       
					        				 for(DataActividad acti : mapaCategoria.getValue()){
					        					actividadesCombo.add(acti.getName());
					        				}	 					   
					        			}
					        		}
							      	if(!actividadesCombo.isEmpty()){
					        			for(String actividad: actividadesCombo){
					        		%>
											<option value="<%=actividad%>"><%=actividad%></option>
					        			
					        			<%
					        			}				        			
					        		}
					        		%>				        		
												</select>
												<input type="submit" value="siguiente">
											</form>
										</div>
									</div>
	                    <%
	                    		}
	                    %>
							        
					
					
				
            </div>
		
		</div>
		
       
    </body>
</html>