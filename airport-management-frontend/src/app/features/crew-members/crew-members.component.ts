import {Component, OnDestroy, OnInit} from '@angular/core';
import {CrewMemberService} from "../../core/services/crew.member.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CrewMember} from "../../shared/models/CrewMember";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-crew-members',
  templateUrl: './crew-members.component.html',
  providers: [CrewMemberService]
})
export class CrewMembersComponent implements OnInit, OnDestroy {
  public members: CrewMember[] = [];
  // private subscription$: Subscription;

  constructor(private readonly crewMemberService: CrewMemberService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.getCrewMembers();
  }

  private getCrewMembers(): void {
    this.crewMemberService.getCrewMembers().subscribe(response => {
      console.log(response.crewMembers);
      this.members = response.crewMembers;
    })
  }

  ngOnDestroy(): void {
    // this.subscription$.unsubscribe();
  }

  getCrewMemberById(id: number) {

  }

  deleteCrewMember(id: number) {

  }
}
