import {Component, OnDestroy, OnInit} from '@angular/core';
import {CrewMembersWithFlights} from "../../shared/models/CrewMembersWithFlights";
import {CrewMemberService} from "../../core/services/crew.member.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-crew-member',
  templateUrl: './crew-member.component.html',
  providers: [CrewMemberService]
})
export class CrewMemberComponent implements OnInit, OnDestroy {
  private _crewMember?: CrewMembersWithFlights;
  private subscription$?: Subscription;

  constructor(private readonly crewMemberService: CrewMemberService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.subscription$ = this.activatedRoute.params.subscribe(params => {
      this.crewMemberService.getCrewMemberById(Number(params['id'])).subscribe(response => {
        this._crewMember = response;
      })
    })
  }

  get crewMember(): CrewMembersWithFlights {
    return <CrewMembersWithFlights>this._crewMember;
  }

  private getCrewMember() {

  }

  public routeToEditForm(id: number) {

  }

  deleteFlightFromCrewMember(id: number) {

  }

  ngOnDestroy(): void {
  }
}
