import {RouterModule, Routes} from "@angular/router";
import {CrewMembersComponent} from "./features/crew-members/crew-members.component";
import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {FlightsComponent} from "./features/flights/flights.component";
import {CrewMemberComponent} from "./features/crew-member/crew-member.component";

const routes: Routes = [
  {
    path: "",
    component: AppComponent
  },
  {
    title: 'Crew members',
    path: 'crew-members',
    component: CrewMembersComponent
  },
  {
    title: 'Crew member',
    path: 'crew-members/get/:id',
    component: CrewMemberComponent
  },
  {
    title: 'Flights',
    path: 'flights',
    component: FlightsComponent
  },
]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
