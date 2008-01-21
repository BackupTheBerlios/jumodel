from Offer o 
	fetch join o.category
	fetch join o.quarter
	fetch join o.transport
	fetch join o.quarter
	fetch join o.offerPromotions prom
	fetch join prom.promotion
	
	where o
	
	