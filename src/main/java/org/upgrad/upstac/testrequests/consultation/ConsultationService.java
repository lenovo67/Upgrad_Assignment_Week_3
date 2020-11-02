package org.upgrad.upstac.testrequests.consultation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.transaction.Transactional;

@Service
@Validated
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    private static Logger logger = LoggerFactory.getLogger(ConsultationService.class);


    @Transactional
    public Consultation assignForConsultation( TestRequest testRequest, User doctor) {
        //Implement this method to assign the consultation service
        // create object of Consultation class and use the setter methods to set doctor and testRequest details
        Consultation newConsult = new Consultation();
        newConsult.setDoctor(doctor);
        newConsult.setRequest(testRequest);

        // make use of save() method of consultationRepository to return the Consultation object
        return consultationRepository.save(newConsult);
       // return null; // replace this line with your code


    }

    public Consultation updateConsultation(TestRequest testRequest , CreateConsultationRequest createConsultationRequest) {
        //Implement this method to update the consultation
        // create an object of Consultation and make use of setters to set Suggestion, Comments, and UpdatedOn values
        Consultation newConsult = new Consultation();

        newConsult.setSuggestion(createConsultationRequest.getSuggestion());
        newConsult.setComments(createConsultationRequest.getComments());
            newConsult.setUpdatedOn(LocalDate.now());
            // make use of save() method of consultationRepository to return the Consultation object
            return consultationRepository.save(newConsult); // replace this line with your code


    }


}
