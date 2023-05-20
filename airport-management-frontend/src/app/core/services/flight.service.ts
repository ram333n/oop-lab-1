import {Injectable} from "@angular/core";
import {BACKEND_APIS} from "../util/backend-apis";
import {HttpClient} from "@angular/common/http";
import {Flight} from "../../shared/models/Flight";
import {Observable} from "rxjs";

@Injectable({
  providedIn: "root"
})
export class FlightService {
  private baseUrl = BACKEND_APIS.flightApi

  constructor(private httpClient:HttpClient) {
  }

  public getAllFlights(): Observable<{flights: Flight[]}> {
    return this.httpClient.get<{flights: Flight[]}>(`${this.baseUrl}/list`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/delete?id=${id}`);
  }
}
