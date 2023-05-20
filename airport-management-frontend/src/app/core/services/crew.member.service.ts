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

  constructor(private httpClient: HttpClient) {
  }

  public getCrewMembers(): Observable<{crewMembers: CrewMember[]}> {
    return this.httpClient.get<{crewMembers: CrewMember[]}>(`${this.baseUrl}/list`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/delete?id=${id}`);
  }
}