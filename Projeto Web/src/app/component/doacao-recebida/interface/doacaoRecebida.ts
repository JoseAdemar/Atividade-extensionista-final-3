export interface DoacaoRecebida {
    doacaoId: number,
    totalItens: number,
    produtos: string,
    doacaoRecolhida: boolean,
    nomeDoador:string
    emailDoador:string
    telefoneDoador:string  
    cep:string
    uf:string
    localidade:string
}