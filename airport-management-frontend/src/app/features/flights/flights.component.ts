import {Component, OnDestroy, OnInit} from '@angular/core';
import {Flight} from "../../shared/models/Flight";
import {CrewMemberService} from "../../core/services/crew.member.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FlightService} from "../../core/services/flight.service";

@Component({
  selector: 'app-flights',
  templateUrl: './flights.component.html',
  providers: [CrewMemberService]
})
export class FlightsComponent implements OnInit, OnDestroy {
  private _flights: Flight[] = [];

  constructor(private readonly flightService: FlightService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.getAllFlights();
  }

  private getAllFlights(): void {
    this.flightService.getAllFlights().subscribe(response => {
      this._flights = response.flights;
    })
  }

  get flights(): Flight[] {
    return this._flights;
  }

  getFlightById(id: number): void {

  }

  deleteFlight(id: number): void {
    const confirmDelete = confirm(`Do you want to delete flight with id: ${id}?`);

    if (confirmDelete) {
      this.flightService.delete(id).subscribe(() => {
        this.getAllFlights();
      })
    }
  }

  ngOnDestroy(): void {
  }

}