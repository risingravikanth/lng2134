<!--footer-->
			<div class="footer">
		   		<p>&copy; 2016 OG Analysis Admin Panel. All Rights Reserved | Design by <a href="https://w3layouts.com/" target="_blank">Profectus Solutions</a></p>
			</div>
        	<!--//footer-->
		</div><!-- main-content div closing -->
		<!-- Classie -->
		<script src="${pageContext.request.contextPath}/js/layout/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			
			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
		<!--scrolling js-->
		<script src="${pageContext.request.contextPath}/js/layout/jquery.nicescroll.js"></script>
		<script src="${pageContext.request.contextPath}/js/layout/scripts.js"></script>
		<!--//scrolling js-->
		<!-- Bootstrap Core JavaScript -->
   		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"> </script>	<!--  Actual existing file is bootstrap.js -->
   		<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
   		<!-- application related js files -->
   			<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    		<script src="${pageContext.request.contextPath}/js/ajax.js"></script>        		
    	<!-- application related js files -->
    	