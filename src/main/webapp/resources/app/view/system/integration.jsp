<%@ page session="false" %>
<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header"><i class="fa fa fa-bars"></i>Integration</h3>
        <ol class="breadcrumb">
            <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
            <li><i class="fa fa-bars"></i>Integration</li>
        </ol>
    </div>
</div>

<div class="form-group">
    <button id="btnSearch" style="min-width: 150px;" class="btn btn-info" ng-click="searchSummery(enteredText)"
            data-toggle="modal" data-target="#myModal">Summarize</button>
</div>

<br /><br />

<div class="panel panel-default">
  <div class="panel-heading">HTML Content</div>
  <div class="panel-body" style="height: 400px;">
    <div id="check">
  	<h1>Big Data and the Future of Business</h1>
	<p class="Pa16">The basis of commercial enterprise is information. That hasn’t changed in thousands of years.&nbsp;</p>
	<p class="Pa16">However, those who feel that today’s big data is just a continuation of past information trends are as wrong as if they were to claim that a stone tablet is essentially the same as a tablet computer or an abacus similar to a supercomputer.</p>
	<p class="Pa11">Today, we have more information than ever. But the importance of all that information extends beyond simply being able to do more, or know more, than we already do. The quantitative shift leads to a qualitative shift. Having more data allows us to do new things that weren’t possible before. In other words: More is not just more. More is new. More is better. More is different.</p>
	<p>Of course, there are still limits on what we can obtain from or do with data. But most of our assumptions about the cost of collecting and the difficulty of processing data need to be overhauled. No area of human endeavor or industrial sector will be immune from the incredible shakeup that’s about to occur as big data plows through society, politics, and business. People shape their tools&mdash;and their tools shape them.</p>
	<p class="Pa16">This new world of data, and how companies can harness it, bumps up against two areas of public policy and regulation. The first is employment. Big data and associated algorithms challenge white-collar knowledge workers in the 21st century in the same way that factory automation and the assembly line eroded blue-collar labor in the 19th and 20th centuries. But there are benefits: Big data will bring about great things in society. We like to think that technology leads to job creation, even if it comes after a temporary period of disruption. That was certainly true during the Industrial Revolution. To be sure, it was a devastating time of dislocation, but it eventually led to better livelihoods. Yet this optimistic outlook ignores the fact that some industries simply never recover from change. When tractors and automobiles replaced horse-drawn plows and carriages, the need for horses in the economy basically ended.</p>
	<p class="Pa16">The upheavals of the Industrial Revolution cre­ated political change and gave rise to new economic philosophies and political movements. It’s not much of an intellectual stretch to predict that new political philosophies and social movements will arise around big data, robots, computers, and the Internet, and the effect of these technologies on the economy and representative democracy. Recent debates over income inequality and the Occupy movement seem to point in that direction.</p>
	<p class="Pa16">The second policy area is privacy. Of course, privacy was an issue even with “small data,” but it’s a much greater challenge in the big data era. Here, too, more is different. The nature of securing personal information changes when potential privacy threats happen not daily or hourly, but 1,000 times per second. It also changes when the act of collecting data happens invisibly and passively, as the byproduct of other services, rather than overtly and actively. It’s hard to imagine how classic privacy law will work in that world, or how a person whose privacy has been violated would take action&mdash;or even be aware of the situation.</p>
	<p>It gets worse. A basis of privacy law around the world is the principle, enshrined by the Organization for Economic Cooperation &amp; Development privacy guidelines, that an entity should discard data once its primary purpose has been fulfilled. But the whole point of big data is that we ought to save data forever because we can’t know today all the valuable ways it might be used tomorrow.</p>
	<p class="Pa16">For that reason, we need regulators who understand that the rules that govern big data can’t just be more&mdash;that is, more of the same. In fact, today’s rules do a poor job of protecting privacy, so simply heading forward with more of the existing mediocre policies makes little sense. Instead, big data businesses are crying out for regulations that are new, better, and, of course, different.</p>
	<p class="Pa16">Big data will change business, and business will change society. The hope, of course, is that the benefits will outweigh the drawbacks, but that is mostly a hope. The big-data world is still very new, and, as a society, we’re not very good at handling all the data that we can collect now. We also can’t foresee the future. Technology will continue to surprise us, just as it would an ancient man with an abacus looking upon an iPhone. What <em>is</em> certain is that more will not be more: It will be different.</p>
	<p class="Default"><strong><span style="font-size: 13.0080003738403px; line-height: 1.538em;">Read the full article </span><a target="_blank" href="https://www.bbvaopenmind.com/en/article/big-data-and-the-future-of-business/?utm_source=views&amp;utm_medium=article03&amp;utm_campaign=MITcompany&amp;utm_content=cukier-big-data" style="font-size: 13.0080003738403px; line-height: 1.538em;">here</a><span style="font-size: 13.0080003738403px; line-height: 1.538em;">.</span></strong></p></section>
  	</div>
  </div>
</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document" style="top:auto; bottom: auto; right: auto; left: auto;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Summary</h4>
      </div>
      <div class="modal-body">
        	<div class="panel panel-default" ng-show="summaryTextShow"  name="enteredText" rows="10" name="original_text">
    		<div class="panel-body">
	    		<ul class="list-group">
    			<li class="list-group-item" ng-repeat="s in summaryText">{{ s }} </li>
    		</ul>
    		</div>
    	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>