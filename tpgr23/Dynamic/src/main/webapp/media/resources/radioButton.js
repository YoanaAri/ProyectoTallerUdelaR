function activarDeptCat() {
	let radioDepartamento = document.getElementById("departamento");
	let radioCategoria = document.getElementById("categoria");
	
	let comboDepto = document.getElementById("comboBoxDep");
	let comboCat = document.getElementById("comboBoxCat");
	
	if ( radioDepartamento.checked ) {									
		
		comboCat.hidden = true;
		comboDepto.hidden = false;		
		
	} else if(radioCategoria.checked) {									
		
		comboDepto.hidden = true;
		comboCat.hidden = false;
		
	}
}


function habilitacion() {

	let radioTurista = document.getElementById("turista");
	let radioProveedor = document.getElementById("proveedor");
	
	let labelDescripcion = document.getElementById("labelDescripcion");
	let labelNacionalidad = document.getElementById("labelNacionalidad");
	let labelLink = document.getElementById("labelLink");
	let descripcion = document.getElementById("descripcion");
	let nacionalidad = document.getElementById("nacionalidad");
	descripcion.required = true;
	nacionalidad.required = true;

	
	if ( radioProveedor.checked ) {									
		/*document.getElementById("labelNacionalidad").hidden= true;									
		document.getElementById("labelLink").removeAttribute("hidden");
		document.getElementById("labelDescripcion").removeAttribute("hidden");							
		document.getElementById("descripcion").required =true;	
		document.getElementById("nacionalidad").removeAttribute("required");*/
		
		labelDescripcion.hidden = false;
		labelLink.hidden = false;
		labelNacionalidad.hidden = true;
		if(!descripcion.required){
			descripcion.required = true;
		};
		if(nacionalidad.required){
			nacionalidad.removeAttribute("required");
		};
		
				
		
	} else if(radioTurista.checked) {									
		/*document.getElementById("labelDescripcion").hidden= true;
		document.getElementById("labelLink").hidden= true;
		document.getElementById("labelNacionalidad").removeAttribute("hidden");		
		document.getElementById("nacionalidad").setAttribute("required", true);
		document.getElementById("descripcion").removeAttribute("required");	*/
		
		labelDescripcion.hidden = true;
		labelLink.hidden = true;
		labelNacionalidad.hidden = false;
		if(descripcion.required){
			descripcion.removeAttribute("required");
		};
		if(!nacionalidad.required){
			nacionalidad.required = true;
		};
		
	}
}
            		
function checkPasswords(form) {
    password1 = document.getElementById("password");
	password2 = document.getElementById("passwordcon");
  
 	if (password1.value !== password2.value) {
		alert("las contraseñas deben coincidir");
        return false;
    }
  

    else{
  	  alert("¡Se ha registrado exitosamente!");
   	 return true;
    }
}

var check = function() {
  if (document.getElementById('password').value ==
    document.getElementById('passwordcon').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'matching';
        document.getElementById('enviar').removeAttribute('disabled');

  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'not matching';
    document.getElementById('enviar').disabled = true;
  }
}