<%@ page session="false" %>
<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header"><i class="fa fa fa-bars"></i>Type In</h3>
        <ol class="breadcrumb">
            <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
            <li><i class="fa fa-bars"></i>Type In</li>
        </ol>
    </div>
</div>

<div class="form-group">
    <label>Content</label>
    <textarea class="form-control" ng-model="enteredText"  name="enteredText" rows="10" name="original_text"></textarea>

</div>
<div class="form-group">
    <div class="col-sm-offset-10 col-sm-2">
    	<button id="btnSearch" style="min-width: 150px;" class="btn btn-info" ng-click="searchSummery(enteredText)"
    	data-toggle="modal" data-target="#myModal">Summarize</button>
    </div>
    
</div>


<div class="form-group" ng-show="summaryTextShow">
    <label>Summary</label>
    <div class="panel panel-default" ng-show="summaryTextShow"  name="enteredText" rows="10" name="original_text">
    	<div class="panel-body">
	    	{{ summaryText }}
    	</div>
    </div>
</div>



<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document" style="top:auto; bottom: auto; right: auto; left: auto;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        	<div class="panel panel-default" ng-show="summaryTextShow"  name="enteredText" rows="10" name="original_text">
    		<div class="panel-body">
	    		{{ summaryText }}
    		</div>
    	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>