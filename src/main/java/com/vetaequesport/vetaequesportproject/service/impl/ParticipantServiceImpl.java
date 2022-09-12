package com.vetaequesport.vetaequesportproject.service.impl;

import com.vetaequesport.vetaequesportproject.entity.Application;
import com.vetaequesport.vetaequesportproject.entity.ApplicationForm;
import com.vetaequesport.vetaequesportproject.entity.Rout;
import com.vetaequesport.vetaequesportproject.repository.ApplicationRepository;
import com.vetaequesport.vetaequesportproject.repository.RoutRepository;
import com.vetaequesport.vetaequesportproject.service.ParticipantService;
import com.vetaequesport.vetaequesportproject.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
    public class ParticipantServiceImpl implements ParticipantService {
        private ApplicationRepository participantRepository;
        private RoutRepository routRepository;
        private Validator validator;

        @Autowired
        public ParticipantServiceImpl(ApplicationRepository participantRepository, Validator validator, RoutRepository routRepository) {
            this.participantRepository = participantRepository;
            this.validator = validator;
            this.routRepository = routRepository;
        }



        public void addParticipant(ApplicationForm applicationForm) {
            participantRepository.addParticipant(applicationForm.getNameParticipant(), applicationForm.getHorseName(), applicationForm.getRang(),
                    applicationForm.getYearOfBirth());

        }
        public List<Rout> findAllRoutes(){
           return routRepository.findAllRouts();
        }

        public List<Application> findByRang(int rang){
            return participantRepository.findByRang(rang);
        }
    }
