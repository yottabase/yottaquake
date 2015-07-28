<%@ include file="layout/header.jsp"%>

<div class="container-fluid">

	<div class="row">
		<div class="col-md-3" id="filters">

			<h3>Filtri</h3>
			<form>
				<div class="form-group">
					<label for="exampleInputPassword1">Magnitudo</label>

					<div class="row">
						<div class="col-md-12">
							<input type="text" class="magnitude" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="exampleInputPassword1">Periodo</label>

					<div class="row">
						<div class="col-md-6">
							Dal <input type="text" class="form-control input-block from">

						</div>
						<div class="col-md-6">
							Al <input type="text" class="form-control input-block to">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="exampleInputPassword1">Profondita</label>

					<div class="row">
						<div class="col-md-12">
							<input type="text" class="depth" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="exampleInputPassword1">Layer di visualizzazione</label>

					<div class="checkbox">
						<label><input type="checkbox" class="political">Mappa
							politica</label>
					</div>
					<div class="checkbox">
						<label><input type="checkbox" class="flinnRegions">Regioni di
							Flinn</label>
					</div>
					<div class="checkbox">
						<label><input type="checkbox" class="events">Eventi</label>
					</div>
					<div class="checkbox">
						<label><input type="checkbox" class="heatMap">Heat map</label>
					</div>
				</div>

				<button type="submit" class="btn btn-primary pull-right">Aggiorna</button>
			</form>
		</div>

		<div class="col-md-9" id="graph">
			<div id="chart-events-map"></div>
		</div>
	</div>









	<br />
</div>
<!-- /.container -->


<!-- <div id="chart-events-by-month"></div>
			
			<div id="chart-events-by-year"></div>-->

<%@ include file="layout/footer.jsp"%>