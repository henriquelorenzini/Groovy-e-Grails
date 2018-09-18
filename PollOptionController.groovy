package simple.poll

import grails.converters.*
import grails.validation.ValidationException

class PollOptionController {

    def list() { 
    	def pollOptions = PollOption.findAll()
    	def result = [pollOptionList:pollOptions]
    	render (result as JSON)
	}

	def create(){
		def pollOption = new PollOption()
		pollOption.description = params.description
		pollOption.save(flush:true, failOnError:true)
		render(pollOption as JSON)
	}

	def update(){
		def pollOption = PollOption.findById(params.id)
		pollOption.description = params.description
		pollOption.save(flush:true, failOnError:true)
		render (pollOption as JSON)
	}
