import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoacaoRecebidaComponent } from './doacao-recebida.component';

describe('DoacaoRecebidaComponent', () => {
  let component: DoacaoRecebidaComponent;
  let fixture: ComponentFixture<DoacaoRecebidaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoacaoRecebidaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoacaoRecebidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
