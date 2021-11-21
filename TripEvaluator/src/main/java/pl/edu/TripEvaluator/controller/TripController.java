package pl.edu.TripEvaluator.controller;

import pl.edu.TripEvaluator.service.TripService;
import pl.edu.TripEvaluator.entity.Trip;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TripController {

    private TripService tripService;

    public TripController() {
    }

    @Autowired
    public TripController(TripService tripService) {
        this.tripService=tripService;
    }


    @GetMapping("/findAllTrips")
    public ResponseEntity<Iterable<Trip>> findAll() {
        return ResponseEntity.ok(tripService.findAll());
    }

    @PostMapping(path = "/addNewTrip")
    public ResponseEntity addNewTrip (@RequestBody Trip trip) {
        Trip createdTrip = tripService.saveNewTrip(trip);
        return new ResponseEntity<Trip>(createdTrip, HttpStatus.OK);
    }

    @PutMapping("/updateTrip/{id}")
    public ResponseEntity updateTripById(@RequestBody Trip trip, @PathVariable Integer id) {

        Optional<Trip> tripOptional = Optional.ofNullable(tripService.getTripById(id));
        if(tripOptional.isPresent() ) {
            Trip updatedTrip = tripOptional.get();
            updatedTrip.setTytul(trip.getTytul());
            updatedTrip.setDestynacja(trip.getDestynacja());
            updatedTrip.setCena(trip.getCena());
            updatedTrip.setReviewList(trip.getReviewList());
            tripService.saveNewTrip(updatedTrip);
        }else{
            tripService.saveNewTrip(trip);
        }
        return ResponseEntity.ok("The book has been successfully updated");
    }

//    @PutMapping("/updateTripRewiev/{id}")
//    public ResponseEntity updateTripById(@RequestBody Trip trip, @PathVariable Integer id) {
//
//        Optional<Trip> tripOptional = Optional.ofNullable(tripService.getTripById(id));
//
//        if(tripOptional.isPresent() ) {
//            Trip updatedTrip = tripOptional.get();
//            updatedTrip.setTytul(trip.getTytul());
//            updatedTrip.setDestynacja(trip.getDestynacja());
//            updatedTrip.setCena(trip.getCena());
//            updatedTrip.setReviewList(trip.getReviewList());
//            tripService.saveNewTrip(updatedTrip);
//        }else{
//            tripService.saveNewTrip(trip);
//        }
//        return ResponseEntity.ok("The book has been successfully updated");
//    }

    @PostMapping(path = "/addNewRewiev")
    public ResponseEntity addNewTrip (@RequestBody Trip trip, @PathVariable Integer id) {


        Trip createdTrip = tripService.saveNewTrip(trip);
        return new ResponseEntity<Trip>(createdTrip, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTrip/{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable Integer id) {
        tripService.deleteTripById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getTripById/{id}")
    public ResponseEntity<Trip> getTripId (@PathVariable Integer id) {
        tripService.getTripById(id);
        return ResponseEntity.ok(tripService.getTripById(id));
    }


}
