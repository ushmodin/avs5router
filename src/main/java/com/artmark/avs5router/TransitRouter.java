package com.artmark.avs5router;

import com.artmark.avs5router.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nikolay on 19.03.17.
 */
@RestController
public class TransitRouter {
	@Autowired
	private TransitService transitService;

	@RequestMapping("/transit/book")
	public TransitBookResponse book(@RequestBody TransitBookRequest request) {
		return transitService.book(request);
	}

	@RequestMapping("/transit/confirm")
	public TransitConfirmResponse confirm(@RequestBody TransitConfirmRequest request) {
		return transitService.confirm(request);
	}

	@RequestMapping("/transit/cancel")
	public TransitCancelResponse cancel(@RequestBody TransitCancelRequest request) {
		return transitService.cancel(request);
	}
}
