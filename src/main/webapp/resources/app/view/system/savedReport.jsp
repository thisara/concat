<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header"><i class="fa fa fa-bars"></i>Saved Report</h3>
        <ol class="breadcrumb">
            <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
           <li><i class="fa fa-bars"></i>Saved Report</li>
 <!--            <li><i class="fa fa-square-o"></i>Pages</li>-->
        </ol>
    </div>
</div>

<table>
    <tr>
        <th width="80">ID</th>
        <th width="120">Summary </th>
        <th width="120">Search Text</th>
        <th width="120">User Identity</th>
    </tr>

    <tr ng-repeat = "summary in summaryList">
        <td>{{ summary.id }}</td>
        <td>{{ summary.summary }}</td>
        <td>{{ summary.originalText }}</td>
        <td>{{ summary.userIdentity }}</td>
    </tr>
</table>