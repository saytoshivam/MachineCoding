package services;

import entities.Patient;

public interface IPatientService extends IUserService {
    int register(Patient p);
}
