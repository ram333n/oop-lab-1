import {RouterModule, Routes} from "@angular/router";
import {CrewMembersComponent} from "./features/crew-members/crew-members.component";
import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {FlightsComponent} from "./features/flights/flights.component";

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
