
function ond () {
	// body... 
	var tr = document.getElementsByTagName("tr");
	for (var i = tr.length - 1; i >= 0; i--) {
		if(i%2==0){
			tr[i].style.backgroundColor = "#02FF00FF";
		}else {
			
			tr[i].style.backgroundColor = "#FFEF00FF";
		}
	}
}
var oldColor;
function ono (c) {
	// body... 
	oldColor = c.style.backgroundColor;
	c.style.backgroundColor = "#FFFFFFFF";
}
function onm (c) {
	// body... 
	c.style.backgroundColor = oldColor;
	//alert(oldColor);
}