const sequence = {
    _id: 1,
    get id() { return this._id++ }
}

const clones = {}

function salvar(clone) {
    if (!clone.id) clone.id = sequence.id
    clones[clone.id] = clone
    return clone
}

function excluir(id) {
    const clone = clones[id]
    delete clones[id]
    return clone
}

function getClone(id) {
    return clones[id] || {}
}

function getClones() {
    return Object.values(clones)
}

module.exports = { salvar, excluir, getClone, getClones }