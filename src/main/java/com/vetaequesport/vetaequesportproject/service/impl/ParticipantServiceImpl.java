package com.vetaequesport.vetaequesportproject.service.impl;

import com.vetaequesport.vetaequesportproject.entity.ApplicationForm;
import com.vetaequesport.vetaequesportproject.entity.User;
import com.vetaequesport.vetaequesportproject.repository.ParticipantRepository;
import com.vetaequesport.vetaequesportproject.repository.UserRepository;
import com.vetaequesport.vetaequesportproject.service.ParticipantService;
import com.vetaequesport.vetaequesportproject.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


    @Service
    public class ParticipantServiceImpl implements ParticipantService {
        private ParticipantRepository participantRepository;
        private Validator validator;

        @Autowired
        public ParticipantServiceImpl(ParticipantRepository participantRepository, Validator validator) {
            this.participantRepository = participantRepository;
            this.validator = validator;
        }



        public void addParticipant(ApplicationForm applicationForm) {
            participantRepository.addParticipant(applicationForm.getNameParticipant(), applicationForm.getHorseName(), applicationForm.getRang(),
                    applicationForm.getYearOfBirth());

        }
    }
