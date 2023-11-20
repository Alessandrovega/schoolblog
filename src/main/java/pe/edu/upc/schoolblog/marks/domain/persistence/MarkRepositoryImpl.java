package pe.edu.upc.schoolblog.marks.domain.persistence;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.marks.domain.entity.Mark;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MarkRepositoryImpl implements MarkRepository {
    @Override
    public List<Mark> findByStudentId(Integer studentId) {
        return null;
    }

    @Override
    public List<Mark> findByTeacherId(Integer teacherId) {
        return null;
    }

    @Override
    public Optional<Mark> findByEvaluationId(Integer evaluationId) {
        return Optional.empty();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Mark> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Mark> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Mark> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Mark getOne(Integer integer) {
        return null;
    }

    @Override
    public Mark getById(Integer integer) {
        return null;
    }

    @Override
    public Mark getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Mark> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Mark> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Mark> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Mark> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Mark> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Mark> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Mark, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Mark> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Mark> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<Mark> findByStudent(Student student) {
        return null;
    }

    @Override
    public List<Mark> findByEvaluation(Evaluation evaluation) {
        return null;
    }

    @Override
    public Optional<Mark> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Mark> findAll() {
        return null;
    }

    @Override
    public List<Mark> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Mark entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Mark> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Mark> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Mark> findAll(Pageable pageable) {
        return null;
    }
}
