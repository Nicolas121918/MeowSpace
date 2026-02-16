import { Observable } from 'rxjs';
import { Breed } from '../breed.model';

export abstract class GetBreedByIdUseCase {
  abstract execute(id: string): Observable<Breed>;
}