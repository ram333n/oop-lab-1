import {Injectable} from "@angular/core";
import {BACKEND_APIS} from "../util/backend-apis";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CrewMember} from "../../shared/models/CrewMember";

@Injectable({
  providedIn: "root"
})
export class CrewMemberService {
  private baseUrl = BACKEND_APIS.crewMemberApi

  constructor(private http: HttpClient) {
  }

  public getCrewMembers(): Observable<{crewMembers: CrewMember[]}> {
    return this.http.get<{crewMembers: CrewMember[]}>(`${this.baseUrl}/list`)
  }
}
