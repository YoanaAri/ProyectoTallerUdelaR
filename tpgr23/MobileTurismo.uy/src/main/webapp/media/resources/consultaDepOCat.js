/**
 * 
 */
function eleccionCatODep() {
	let radioDep = document.getElementById("radioDep");
	let radioCat = document.getElementById("radioCat");
	if (radioDep.checked) {
		document.getElementById("textoDep").removeAttribute("hidden");
		document.getElementById("departamentos").removeAttribute("hidden");
		document.getElementById("departamentos").name = "dep";
		document.getElementById("textoCat").hidden = true;
		document.getElementById("categorias").removeAttribute("name");
		document.getElementById("categorias").removeAttribute("required");
		document.getElementById("categorias").hidden = true;
		document.getElementById("botonDepOCat").removeAttribute("hidden");
	}
	if (radioCat.checked) {
		document.getElementById("textoCat").removeAttribute("hidden");
		document.getElementById("categorias").removeAttribute("hidden");
		document.getElementById("categorias").name = "cat";
		document.getElementById("textoDep").hidden = true;
		document.getElementById("departamentos").removeAttribute("name");
		document.getElementById("departamentos").removeAttribute("required");
		document.getElementById("departamentos").hidden = true;
		document.getElementById("botonDepOCat").removeAttribute("hidden");

	}
}