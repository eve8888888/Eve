function ock () {
			// body... 
			var v = document.getElementById("t1");
			var n = document.getElementsByName("as");
			for (var i = n.length - 1; i >= 0; i--) {
				if(v.checked == true){
					n[i].checked = true;
				}else {
					n[i].checked = false;
				}
			}
		}
		//批量删除
		function del () {
			var con = 0;
			var n = document.getElementsByName("as");
			for (var i = n.length - 1; i >= 0; i--) {
				if(n[i].checked == true){
					con++;
				}
			}
			if(con!=0)
				var f = confirm("你真的要删除这"+con+"条数据吗");
			if(f){
				alert("删除成功");
			}
		}