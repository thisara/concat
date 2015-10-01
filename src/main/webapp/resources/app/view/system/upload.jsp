<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header"><i class="fa fa fa-bars"></i>Upload Content</h3>
        <ol class="breadcrumb">
            <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
           <li><i class="fa fa-bars"></i>Upload</li>
 <!--            <li><i class="fa fa-square-o"></i>Pages</li>-->
        </ol>
    </div>
</div>

<div class="form-group">
    <label for="exampleInputFile">Select File</label>
    <input type="file" id="exampleInputFile" ng-model="selectedFile"  name="selectedFile">
</div>

<div class="form-group">
    <div class="col-sm-offset-10 col-sm-2">
        <button id="btnSearch" style="min-width: 150px;" class="btn btn-info" ng-click="searchUploadedSummery(selectedFile)">Summarize</button>
    </div>
</div>

<div class="form-group" ng-show="summaryUploadTextShow">
    <label>Summary</label>
    <div class="form-control" ng-bind="summaryUploadText" ng-show="summaryUploadTextShow"  name="enteredText" rows="10" name="original_text"></div>

</div>
