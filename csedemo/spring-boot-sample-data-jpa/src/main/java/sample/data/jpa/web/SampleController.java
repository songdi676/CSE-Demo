/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa.web;

import java.util.List;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.People;
import sample.data.jpa.service.PeopleService;

@Controller
@RestSchema(schemaId = "People")
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

	@Autowired
	private PeopleService peopleService;

	@GetMapping("/findAllPeople")
	@ResponseBody
	@Transactional(readOnly = true)
	public List<People> findAll() {
		return peopleService.findAll();
	}

	@RequestMapping(value = "/findPeopleByName", produces = { "application/json" }, method = RequestMethod.GET)
	public List<People> findByPeopleName(@RequestParam(value = "name") String name) {
		logger.info("find people by name:" + name);
		return peopleService.findByPeopleName(name);
	}

	@RequestMapping(value = "/findPeopleByStatus", produces = { "application/json" }, method = RequestMethod.GET)
	public List<People> findByStatus(@RequestParam(value = "status") int status) {
		logger.info("find people by status:" + status);
		return peopleService.findByStatus(status);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public List<People> save(@RequestBody List<People> peoples) {
		return peopleService.save(peoples);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestBody List<People> peoples) {
		peopleService.delete(peoples);
	}

	@RequestMapping(value = "/deletePeopleByName", produces = { "application/json" }, method = RequestMethod.GET)
	public void deletePeopleByName(@RequestParam(value = "name") String name) {
		peopleService.deleteByPeopleName(name);
	}
}
