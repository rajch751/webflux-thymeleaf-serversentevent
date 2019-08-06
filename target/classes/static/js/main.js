function loadComments () {

    this.source = null;

    this.start = function () {

        var commentTable = document.getElementById("comments");

       
        this.source = new EventSource("/comment/stream");

        this.source.addEventListener("message", function (event) {

        	var comment = JSON.parse(event.data);
            var isfound = false;
        	for(var i = commentTable.rows.length - 1; i > 0; i--)
             {
             	
        		 var firstCellText  = commentTable.rows[i].cells[0].innerText;
        		 //commentTable.rows[i].style='background-color:#F1522B;color:white;text;font-weight:bold;';
        		 if(firstCellText == comment.author) {
        			 commentTable.rows[i].style='background-color:#FB6F5C;color:white;text;font-weight:bold;';
        			 commentTable.rows[i].cells[1].innerHTML=comment.message;
        			 commentTable.rows[i].cells[2].innerHTML=comment.closed;
        			 commentTable.rows[i].cells[3].innerHTML=comment.total;
        			 commentTable.rows[i].cells[4].innerHTML=comment.timestamp;
        			 
        			 isfound=true;
        		 }else {
        			 commentTable.rows[i].style='';
        		 }
             }
        	 
            
        	
        	// These events are JSON, so parsing and DOM fiddling are needed
            if(!isfound) {
            var row = commentTable.getElementsByTagName("tbody")[0].insertRow(0);
            var cell0 = row.insertCell(0);
            var cell1 = row.insertCell(1);
            var cell2 = row.insertCell(2);
            var cell3 = row.insertCell(3);
            var cell4 = row.insertCell(4);

            cell0.className = "author-style";
            cell0.innerHTML = comment.author;

            cell1.className = "text";
            cell1.innerHTML = comment.message;
            
            cell2.className = "text";
            cell2.innerHTML = comment.closed;
            
            cell3.className = "text";
            cell3.innerHTML = comment.total;

            cell4.className = "date";
            cell4.innerHTML = comment.timestamp;
            }

        });

        this.source.onerror = function () {
            this.close();
        };

    };

    this.stop = function() {
        this.source.close();
    }

}

comment = new loadComments();

/*
 * Register callbacks for starting and stopping the SSE controller.
 */
window.onload = function() {
    comment.start();
};
window.onbeforeunload = function() {
    comment.stop();
}