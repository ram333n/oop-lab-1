import {RouterModule, Routes} from "@angular/router";
import {CrewMembersComponent} from "./features/crew-members/crew-members.component";
import {NgModule} from "@angular/core";
import {NavbarComponent} from "./core/components/navbar/navbar.component";
import {AppComponent} from "./app.component";

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
