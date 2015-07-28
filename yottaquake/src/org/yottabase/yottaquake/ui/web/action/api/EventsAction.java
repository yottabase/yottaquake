package org.yottabase.yottaquake.ui.web.action.api;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import org.yottabase.yottaquake.core.BoundingBox;
import org.yottabase.yottaquake.core.LatLng;
import org.yottabase.yottaquake.db.DBFacade;
import org.yottabase.yottaquake.db.DBAdapterManager;
import org.yottabase.yottaquake.ui.web.core.AbstractAction;

public class EventsAction extends AbstractAction{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DBFacade facade = DBAdapterManager.getFacade();
		
		
		// init bbox
		BoundingBox box = null;
		
		String paramTopLeftLat  =  this.cleanParam(request.getParameter("topLeftLat"));
		String paramTopLeftLng  =  this.cleanParam(request.getParameter("topLeftLng"));
		String paramBottomRightLat  =  this.cleanParam(request.getParameter("bottomRightLat"));
		String paramBottomRightLng  =  this.cleanParam(request.getParameter("bottomRightLng"));
		
		if(paramTopLeftLat != null && paramTopLeftLng != null & paramBottomRightLat != null & paramBottomRightLng != null){
			
			LatLng topLeft = new LatLng(Double.parseDouble(paramTopLeftLat), Double.parseDouble(paramTopLeftLng));
			LatLng bottomRight = new LatLng(Double.parseDouble(paramBottomRightLat), Double.parseDouble(paramBottomRightLng));
			
			box = new BoundingBox(topLeft, bottomRight);
		}
		
		// init date
		Date from = null;
		Date to = null;
		
		String paramFrom  =  this.cleanParam(request.getParameter("from"));
		String paramTo  =  this.cleanParam(request.getParameter("to"));
		
		if(paramFrom != null && paramTo != null){
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				from = format.parse(paramFrom);
				to = format.parse(paramTo);
			} catch (ParseException e) {
				response.getWriter().write("Data in formato non valido");
				return;
			}
		}
		
		//init magnitude
		Integer minMagnitude = null;
		Integer maxMagnitude = null;
		
		String paramMinMagnitude  =  this.cleanParam(request.getParameter("minMagnitude"));
		String paramMaxMagnitude  =  this.cleanParam(request.getParameter("maxMagnitude"));
		
		if(paramMinMagnitude != null && paramMaxMagnitude != null){
			minMagnitude = Integer.valueOf(paramMinMagnitude);
			maxMagnitude = Integer.valueOf(paramMaxMagnitude);
		}
		
		//init depth
		Integer minDepth = null;
		Integer maxDepth = null;
		
		String paramMinDepth  =  this.cleanParam(request.getParameter("minDepth"));
		String paramMaxDepth  =  this.cleanParam(request.getParameter("maxDepth"));
		
		if(paramMinDepth != null && paramMaxDepth != null){
			minDepth = Integer.valueOf(paramMinDepth);
			maxDepth = Integer.valueOf(paramMaxDepth);
		}
		

		//init iterable
		Iterable<Document> events = facade.getEvents(box, from, to, minMagnitude, maxMagnitude, minDepth, maxDepth);
		
		JSONObject result = new JSONObject();
		JSONArray items = new JSONArray();
		result.put("items", items);
		
		for(Document doc : events){
			JSONObject event = new JSONObject(doc);
			items.put(event);
		}
		
		response.setContentType(this.CONTENT_TYPE_JSON);
		response.getWriter().write(result.toString());

	}

}
