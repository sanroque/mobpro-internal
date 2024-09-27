package com.mobpro.mobpro_internal.service.service;


import com.mobpro.mobpro_internal.persistence.entity.Client;
import com.mobpro.mobpro_internal.persistence.entity.Work;
import com.mobpro.mobpro_internal.persistence.entity.user.WorkIdentification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Service
public class WorkIdentificationService {

    public WorkIdentification getIdentification(Work work, Client client){

        WorkIdentification workIdentification =
                new WorkIdentification(
                            work.getNumber(),
                            client.getName(),
                            work.getAddress(),
                            work.getNumPAD()
                        );


        return workIdentification;
    }
}
