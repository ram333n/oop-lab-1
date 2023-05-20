import {Position} from "../enums/Position";
import {Flight} from "./Flight";

export interface CrewMembersWithFlights {
  id: number;
  name: string;
  surname: string;
  position: Position;
  flights: Flight[]
}
