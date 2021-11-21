package pl.edu.TripEvaluator.service;

import pl.edu.TripEvaluator.entity.Trip;
import pl.edu.TripEvaluator.repository.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    private static TripRepository tripRepository;


    public TripService() {
    }

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public static Trip saveNewTrip(Trip trip) {tripRepository.save(trip);
        return trip;
    }

    public Iterable<Trip> findAll() {return tripRepository.findAll();}

    public static Trip getTripById(Integer id) {return tripRepository.findById(id).orElseGet(null);}

    public void deleteTripById(Integer id) {tripRepository.deleteById(id);}





}
