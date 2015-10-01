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

<form action="summarize" method="GET">
    <div class="form-group">
        <label>Content</label>
        <textarea class="form-control" rows="10" name="original_text"></textarea>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-10 col-sm-2">
            <input type="submit" value="Summerize"/>
        </div>
    </div>
</form>
