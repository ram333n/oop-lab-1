import { Component } from '@angular/core';
import {FlightService} from "../../core/services/flight.service";
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {FlightWithCrewMembers} from "../../shared/models/FlightWithCrewMembers";

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  providers: [FlightService]
})
export class FlightComponent {
  private _flight?: FlightWithCrewMembers;
  private subscription$?: Subscription;

  constructor(private readonly flightService: FlightService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.subscription$ = this.activatedRoute.params.subscribe(params => {
      this.flightService.getFlightById(Number(params['id'])).subscribe(response => {
        this._flight = response;
      })
    });
  }

  get flight(): FlightWithCrewMembers {
    return <FlightWithCrewMembers>this._flight;
  }

  public routeToEditForm(id: number) {
    this.router.navigate(['flights/edit', id]);
  }

  deleteCrewMemberFromFlight(id: number) {

  }

  ngOnDestroy(): void {
  }
}
