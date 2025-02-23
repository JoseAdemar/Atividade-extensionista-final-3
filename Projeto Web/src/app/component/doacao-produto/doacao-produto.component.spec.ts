import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoacaoProdutoComponent } from './doacao-produto.component';

describe('DoacaoProdutoComponent', () => {
  let component: DoacaoProdutoComponent;
  let fixture: ComponentFixture<DoacaoProdutoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoacaoProdutoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoacaoProdutoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
